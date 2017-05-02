package evolv.io;

import java.util.HashMap;
import java.util.Map;

public interface BrainReceiver {
	public void addSender(BrainSender sender, double weight);
	
	public double getWeight();

	abstract class AbstractBrainReceiver implements BrainReceiver {
		final Map<BrainSender, Double> senders = new HashMap<>();
		
		@Override
		public void addSender(BrainSender sender, double weight) {
			senders.put(sender, weight);

		}
		
		@Override
		public double getWeight() {
			double total = 0;
			for (Map.Entry<BrainSender, Double> sender : senders.entrySet()) {
				total += sender.getKey().getWeight() * sender.getValue();
			}
			return total / senders.size();
		}
	}
}
