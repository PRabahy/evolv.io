package evolv.io;

import java.util.HashMap;
import java.util.Map;

public interface BrainReceiver {
	public void addSender(BrainSender sender, double weight);
	
	abstract class AbstractBrainReceiver implements BrainReceiver {
		final Map<BrainSender, Double> senders = new HashMap<>();
		
		@Override
		public void addSender(BrainSender sender, double weight) {
			senders.put(sender, weight);

		}
		
		double getWeight() {
			double toReturn = 0;
			for (Map.Entry<BrainSender, Double> sender : senders.entrySet()) {
				toReturn += sender.getKey().getWeight() * sender.getValue();
			}
			toReturn /= senders.size();
			return toReturn;
		}
	}
}
