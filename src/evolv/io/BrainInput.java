package evolv.io;

public class BrainInput implements BrainSender {

	private final CreatureSensor input;
	private double lastValue = Double.NaN;

	public BrainInput(CreatureSensor input) {
		this.input = input;
	}

	@Override
	public void addReceiver(BrainReceiver receiver, double weight) {
		receivers.put(receiver, weight);
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
