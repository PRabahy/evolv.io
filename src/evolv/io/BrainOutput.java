package evolv.io;

import evolv.io.BrainReceiver.AbstractBrainReceiver;

public class BrainOutput extends AbstractBrainReceiver {

	private final CreatureAction output;

	public BrainOutput(CreatureAction output) {
		this.output = output;
	}
}
