package org.graphstream.stream.time;

import java.text.ParseException;
import java.util.Calendar;

import org.graphstream.stream.sync.SourceTime;

public class TimestampSourceTime extends SourceTime {
	protected static enum State {
		NOT_INITIALIZED, INITIALIZED, TIMESTAMP_CONSUME, TIMESTAMP_READY
	}

	protected State state = State.NOT_INITIALIZED;
	protected ISODateIO dateIO;
	protected boolean isUsingDateIO = false;
	protected boolean isTimestampUpdated = false;
	protected long timeId = Long.MIN_VALUE;

	public TimestampSourceTime(String sourceId) {
		super(sourceId);
		currentTimeId = -1;
	}

	public ISODateIO getDateIO() {
		return dateIO;
	}
	
	public boolean isUsingTimestamp() {
		return isUsingDateIO;
	}
	
	public void init(String format) throws TimeException {
		if (state != State.NOT_INITIALIZED)
			throw new TimeException(
					"timesamp sourcetime is already initialized");

		try {
			dateIO = new ISODateIO(format);
			isUsingDateIO = true;
			state = State.INITIALIZED;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateTimestamp(String timestamp) throws TimeException {
		if (isUsingDateIO && timestamp == null)
			throw new NullPointerException("timestamp missing");

		if (!isUsingDateIO && timestamp != null)
			init("%K");

		if (isUsingDateIO) {
			Calendar calendar = dateIO.parse(timestamp);
			long timeId = calendar.getTimeInMillis();

			if (timeId <= currentTimeId)
				throw new Error("invalid timestamp");

			currentTimeId = timeId;
		} else currentTimeId++;

		isTimestampUpdated = true;
	}

	public long newEvent() {
		if (isUsingDateIO && !isTimestampUpdated)
			throw new NullPointerException("timestamp missing");

		return currentTimeId;
	}
}
