package evolv.io;

import java.util.HashMap;
import java.util.Map;

public interface BrainSender {
	final Map<BrainReceiver, Double> receivers = new HashMap<>();

	public void addReceiver(BrainReceiver receiver, double weight);
}
