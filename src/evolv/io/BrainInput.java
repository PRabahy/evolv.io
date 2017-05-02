package evolv.io;

import evolv.io.BrainSender.AbstractBrainSender;

public class BrainInput extends AbstractBrainSender {

	private final CreatureSensor input;
	private double lastValue = Double.NaN;

	public BrainInput(CreatureSensor input) {
		this.input = input;
	}

	public double getNewValue() {
		lastValue = input.sense();
		return lastValue;
	}

	public double getLastValue() {
		if (Double.isNaN(lastValue)) {
			getNewValue();
		}
		return lastValue;
	}
	
	public String getLabel() {
		return input.toString();
	}
}
