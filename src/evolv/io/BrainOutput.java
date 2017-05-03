package evolv.io;

import evolv.io.BrainReceiver.AbstractBrainReceiver;

public class BrainOutput extends AbstractBrainReceiver {

	private final CreatureAction output;

	public BrainOutput(CreatureAction output) {
		this.output = output;
	}
	
	public void iterate(double timeStep) {
		output.doAction(getWeight(), timeStep);
	}
	
	public String getLabel() {
<<<<<<< HEAD
		String label = output.getClass().getSimpleName();
		
		if (label.equals("AdjustHue")) label = "Body Hue";
		if (label.equals("AdjustMouthHue")) label = "Mouth Hue";
		return label;
=======
		return output.getClass().getSimpleName();
>>>>>>> 6b0f8b4710f08505a438796e093befcf8b971e94
	}
}
