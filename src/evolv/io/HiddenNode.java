package evolv.io;

public class HiddenNode implements BrainSender, BrainReceiver {

	@Override
	public void addReceiver(BrainReceiver receiver, double weight) {
		receivers.put(receiver, weight);
		receiver.addSender(this, weight);

	}

	@Override
	public void addSender(BrainSender sender, double weight) {
		senders.put(sender, weight);
		sender.addReceiver(this, weight);
	}
}
