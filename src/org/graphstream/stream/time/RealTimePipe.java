/*
 * This file is part of GraphStream.
 * 
 * GraphStream is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * GraphStream is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with GraphStream.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright 2006 - 2010
 * 	Julien Baudry
 * 	Antoine Dutot
 * 	Yoann Pigné
 * 	Guilhelm Savin
 */
package org.graphstream.stream.time;

import org.graphstream.stream.PipeBase;

/**
 * Realtime pipe. This pipe can be used for real time events dispatching.
 * <i>timeId</i> of events is interpreted as a timestamp in milliseconds. When
 * the realtime pipe receives an event, it blocks the delay between the last
 * timeId and the timeId of the new event had been reached.
 * 
 * timeId should be chronologically ordered and can not be equal. So the
 * precision of an event is the millisecond (ie. the delay between two events is
 * at least one milliseconds).
 * 
 * Keep in mind that the pipe blocks the current thread until delay is reached.
 * It is possible to use a {@link org.graphstream.stream.proxy.ThreadProxyPipe}
 * to use realtime dispatching for a source without blocking the other sinks.
 */
public class RealTimePipe extends PipeBase {
	/**
	 * Current timeId of the pipe.
	 */
	protected long currentTimeId = -1;
	/**
	 * System time of the last timeId reception.
	 */
	protected long associatedSystemTime;
	/**
	 * This defines acceleration of the pipe. If 1, then the delay between
	 * events will be exactly the one defined by timeId, understand that if pipe
	 * receive an event e1 with timeId 1000 and an event e2 with timeId 2000,
	 * there will be exactly one second (1000ms) between the dispatching of this
	 * two events. The acceleration provides a way to accelerate or slow this
	 * delay. For example, with an acceleration of 10, delay between e1 and e2
	 * becomes 1000 / 10 = 100ms.
	 */
	protected double acceleration = 1;

	private boolean initialized = false;

	/**
	 * Called by sink methods to block the thread until delay has been reached.
	 * 
	 * @param newTimeId
	 *            new timeId
	 */
	protected void updateAndWaitForDate(long newTimeId) {
		if (initialized) {
			if (newTimeId <= currentTimeId)
				throw new Error("event should be chronologically ordered");

			long pause = (long) ((newTimeId - currentTimeId) / acceleration);

			try {
				Thread.sleep(pause
						- (System.currentTimeMillis() - associatedSystemTime));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else
			initialized = true;

		currentTimeId = newTimeId;
		associatedSystemTime = System.currentTimeMillis();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.graphstream.stream.PipeBase#edgeAttributeAdded(java.lang.String,
	 * long, java.lang.String, java.lang.String, java.lang.Object)
	 */
	public void edgeAttributeAdded(String graphId, long timeId, String edgeId,
			String attribute, Object value) {
		updateAndWaitForDate(timeId);
		sendEdgeAttributeAdded(graphId, timeId, edgeId, attribute, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.graphstream.stream.PipeBase#edgeAttributeChanged(java.lang.String,
	 * long, java.lang.String, java.lang.String, java.lang.Object,
	 * java.lang.Object)
	 */
	public void edgeAttributeChanged(String graphId, long timeId,
			String edgeId, String attribute, Object oldValue, Object newValue) {
		updateAndWaitForDate(timeId);
		sendEdgeAttributeChanged(graphId, timeId, edgeId, attribute, oldValue,
				newValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.graphstream.stream.PipeBase#edgeAttributeRemoved(java.lang.String,
	 * long, java.lang.String, java.lang.String)
	 */
	public void edgeAttributeRemoved(String graphId, long timeId,
			String edgeId, String attribute) {
		updateAndWaitForDate(timeId);
		sendEdgeAttributeRemoved(graphId, timeId, edgeId, attribute);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.graphstream.stream.PipeBase#graphAttributeAdded(java.lang.String,
	 * long, java.lang.String, java.lang.Object)
	 */
	public void graphAttributeAdded(String graphId, long timeId,
			String attribute, Object value) {
		updateAndWaitForDate(timeId);
		sendGraphAttributeAdded(graphId, timeId, attribute, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.graphstream.stream.PipeBase#graphAttributeChanged(java.lang.String,
	 * long, java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void graphAttributeChanged(String graphId, long timeId,
			String attribute, Object oldValue, Object newValue) {
		updateAndWaitForDate(timeId);
		sendGraphAttributeChanged(graphId, timeId, attribute, oldValue,
				newValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.graphstream.stream.PipeBase#graphAttributeRemoved(java.lang.String,
	 * long, java.lang.String)
	 */
	public void graphAttributeRemoved(String graphId, long timeId,
			String attribute) {
		updateAndWaitForDate(timeId);
		sendGraphAttributeRemoved(graphId, timeId, attribute);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.graphstream.stream.PipeBase#nodeAttributeAdded(java.lang.String,
	 * long, java.lang.String, java.lang.String, java.lang.Object)
	 */
	public void nodeAttributeAdded(String graphId, long timeId, String nodeId,
			String attribute, Object value) {
		updateAndWaitForDate(timeId);
		sendNodeAdded(graphId, timeId, nodeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.graphstream.stream.PipeBase#nodeAttributeChanged(java.lang.String,
	 * long, java.lang.String, java.lang.String, java.lang.Object,
	 * java.lang.Object)
	 */
	public void nodeAttributeChanged(String graphId, long timeId,
			String nodeId, String attribute, Object oldValue, Object newValue) {
		updateAndWaitForDate(timeId);
		sendNodeAttributeChanged(graphId, timeId, nodeId, attribute, oldValue,
				newValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.graphstream.stream.PipeBase#nodeAttributeRemoved(java.lang.String,
	 * long, java.lang.String, java.lang.String)
	 */
	public void nodeAttributeRemoved(String graphId, long timeId,
			String nodeId, String attribute) {
		updateAndWaitForDate(timeId);
		sendNodeAttributeRemoved(graphId, timeId, nodeId, attribute);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.graphstream.stream.PipeBase#edgeAdded(java.lang.String, long,
	 * java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	public void edgeAdded(String graphId, long timeId, String edgeId,
			String fromNodeId, String toNodeId, boolean directed) {
		updateAndWaitForDate(timeId);
		sendEdgeAdded(graphId, timeId, edgeId, fromNodeId, toNodeId, directed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.graphstream.stream.PipeBase#edgeRemoved(java.lang.String, long,
	 * java.lang.String)
	 */
	public void edgeRemoved(String graphId, long timeId, String edgeId) {
		updateAndWaitForDate(timeId);
		sendEdgeRemoved(graphId, timeId, edgeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.graphstream.stream.PipeBase#graphCleared(java.lang.String, long)
	 */
	public void graphCleared(String graphId, long timeId) {
		updateAndWaitForDate(timeId);
		sendGraphCleared(graphId, timeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.graphstream.stream.PipeBase#nodeAdded(java.lang.String, long,
	 * java.lang.String)
	 */
	public void nodeAdded(String graphId, long timeId, String nodeId) {
		updateAndWaitForDate(timeId);
		sendNodeAdded(graphId, timeId, nodeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.graphstream.stream.PipeBase#nodeRemoved(java.lang.String, long,
	 * java.lang.String)
	 */
	public void nodeRemoved(String graphId, long timeId, String nodeId) {
		updateAndWaitForDate(timeId);
		sendNodeRemoved(graphId, timeId, nodeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.graphstream.stream.PipeBase#stepBegins(java.lang.String, long,
	 * double)
	 */
	public void stepBegins(String graphId, long timeId, double step) {
		updateAndWaitForDate(timeId);
		sendStepBegins(graphId, timeId, step);
	}
}
