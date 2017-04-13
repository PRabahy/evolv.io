package evolv.io;

public class HiddenNode implements BrainSender, BrainReceiver {

	@Override
	public void addReceiver(BrainReceiver receiver, double weight) {
		receiver.addSender(this, weight);

	}

	@Override
	public void addSender(BrainSender sender, double weight) {
		sender.addReceiver(this, weight);
	}
}
