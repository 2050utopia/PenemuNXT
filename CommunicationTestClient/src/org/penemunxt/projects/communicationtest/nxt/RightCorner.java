package org.penemunxt.projects.communicationtest.nxt;

import org.penemunxt.communication.NXTCommunication;

import lejos.robotics.navigation.SimpleNavigator;
import lejos.robotics.subsumption.Behavior;

public class RightCorner implements Behavior {
	SimpleNavigator simnav;
	DataShare DSL;
	NXTCommunication NXTC;

	public RightCorner(SimpleNavigator simnav, DataShare dsl,
			NXTCommunication nxtc) {
		this.simnav = simnav;
		this.DSL = dsl;
		this.NXTC = nxtc;

	}

	@Override
	public void action() {
		simnav.rotate(-90);

	}

	@Override
	public void suppress() {
		simnav.stop();

	}

	@Override
	public boolean takeControl() {
		if (DSL.LatestRobotData.size() > 9) {
			if ((DSL.LatestRobotData.get(5).getHeadDistance() - DSL.LatestRobotData
					.get(4).getHeadDistance()) > 200
					&& DSL.isLinear ( DSL, 5, 7) && DSL.isLinear ( DSL, 2,4)) {
				return true;
			} else
				return false;
		} else
			return false;
	}


}