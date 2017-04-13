package evolv.io;

import evolv.io.BrainSender.AbstractBrainSender;

public class BrainInput extends AbstractBrainSender {

	private final CreatureSensor input;
	private double lastValue = Double.NaN;

	public BrainInput(CreatureSensor input) {
		this.input = input;
	}

	public double GetNewValue() {
		lastValue = input.sense();
		return lastValue;
	}

	public double GetLastValue() {
		if (Double.isNaN(lastValue)) {
			GetNewValue();
		}
		return lastValue;
	}
}
