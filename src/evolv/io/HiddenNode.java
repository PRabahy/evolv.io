package evolv.io;

import java.util.HashMap;
import java.util.Map;

public class HiddenNode implements BrainSender, BrainReceiver {

	final Map<BrainReceiver, Double> receivers = new HashMap<>();
	final Map<BrainSender, Double> senders = new HashMap<>();
	
	@Override
	public void addSender(BrainSender sender, double weight) {
		sender.addReceiver(this, weight);
		senders.put(sender, weight);
	}
	
	@Override
	public void addReceiver(BrainReceiver receiver, double weight) {
		receiver.addSender(this, weight);
		receivers.put(receiver, weight);
	}

	@Override
	public double getWeight() {
		double total = 0;
		for (Map.Entry<BrainSender, Double> sender : senders.entrySet()) {
			total += sender.getKey().getWeight() * sender.getValue();
		}
		return sigmoid(total / senders.size());
	}
	
	private double sigmoid(double input) {
		return 1.0f / (1.0f + Math.exp(-input));
	}

}
