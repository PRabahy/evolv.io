package evolv.io;

import java.util.HashMap;
import java.util.Map;

public interface BrainReceiver {
	final Map<BrainSender, Double> senders = new HashMap<>();

	public void addSender(BrainSender sender, double weight);
}
