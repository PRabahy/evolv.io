package evolv.io;

public class BrainOutput implements BrainReceiver {

	private final CreatureAction output;

	public BrainOutput(CreatureAction output) {
		this.output = output;
	}

	@Override
	public void addSender(BrainSender sender, double weight) {
		senders.put(sender, weight);

	}
}
