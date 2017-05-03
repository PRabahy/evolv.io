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
<<<<<<< HEAD
		String label = input.getClass().getSimpleName();
		
		if (label.equals("SeeHue")) label = "Hue";
		if (label.equals("SeeSaturation")) label = "Sat";
		if (label.equals("SeeBrightness")) label = "Bri";
		if (label.equals("CreatureEnergySensor")) label = "Energy";
		if (label.equals("CreatureMouthHueSensor")) label = "M Hue";
		return label;
=======
		return input.getClass().getSimpleName();
>>>>>>> 6b0f8b4710f08505a438796e093befcf8b971e94
	}
}
