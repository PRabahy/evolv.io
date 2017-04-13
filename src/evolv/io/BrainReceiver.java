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
	}
}
