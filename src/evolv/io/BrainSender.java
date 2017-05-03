package evolv.io;

import java.util.HashMap;
import java.util.Map;

public interface BrainSender {
	public void addReceiver(BrainReceiver receiver, double weight);
	
	public double getWeight();
	
	abstract class AbstractBrainSender implements BrainSender {
		final Map<BrainReceiver, Double> receivers = new HashMap<>();
		
		@Override
		public void addReceiver(BrainReceiver receiver, double weight) {
			receivers.put(receiver, weight);
		}
	}
}
