package evolv.io;

import evolv.io.BrainSender.AbstractBrainSender;

public class BrainInput extends AbstractBrainSender {

	private final CreatureSensor input;
	private double lastValue = Double.NaN;
	
	private long cachedIteration = 0;

	public BrainInput(CreatureSensor input) {
		this.input = input;
	}

	public double getNewValue() {
		lastValue = input.sense();
		cachedIteration = Board.iterationStep;
		return lastValue;
	}

	public double getWeight() {
		if (Double.isNaN(lastValue) || cachedIteration != Board.iterationStep) {
			getNewValue();
		}
		return lastValue;
	}
	
	public String getLabel() {
		String label = input.getClass().getSimpleName();
		
		if (label.equals("SeeHue")) label = "Hue";
		if (label.equals("SeeSaturation")) label = "Sat";
		if (label.equals("SeeBrightness")) label = "Bri";
		if (label.equals("CreatureEnergySensor")) label = "Energy";
		if (label.equals("CreatureMouthHueSensor")) label = "M Hue";
		return label;
	}
}
