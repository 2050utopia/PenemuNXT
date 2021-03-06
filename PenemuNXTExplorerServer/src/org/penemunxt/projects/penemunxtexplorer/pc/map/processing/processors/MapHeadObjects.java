package org.penemunxt.projects.penemunxtexplorer.pc.map.processing.processors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import org.penemunxt.projects.penemunxtexplorer.RobotData;
import org.penemunxt.projects.penemunxtexplorer.pc.map.processing.IMapProcessor;
import org.penemunxt.projects.penemunxtexplorer.pc.map.processing.MapUtilities;

public class MapHeadObjects extends MapObjectPositions implements IMapProcessor {
	public MapHeadObjects() {
		super();
	}

	public MapHeadObjects(Color c, int size, boolean enabled) {
		super(c, size, enabled);
	}

	@Override
	public void processData(ArrayList<RobotData> data, Graphics g) {
		if (data != null) {
			for (Point objectPos : this.getObjectPositions(data)) {
				MapUtilities
						.paintSquare(objectPos.y, objectPos.x, this.getColor(),
								this.getSize(), g);
			}
		}
	}

	@Override
	public String getName() {
		return "Head objects";
	}

	@Override
	public String getDescription() {
		return "All the places the robot recognizes as objects.";
	}
}
