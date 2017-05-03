package evolv.io;

import java.util.ArrayList;
import java.util.List;

public class Brain {
	private static final int BRAIN_HIDDEN_NODES = Configuration.NUM_EYES * 3 + Configuration.MEMORY_COUNT;
	static final float NEURON_SPACING = 1.1f;
	static final int NEURON_OFFSET_X = -85;
	static final int NEURON_OFFSET_Y = 20;

	private final EvolvioColor evolvioColor;

	// Brain
	private List<BrainInput> inputs = new ArrayList<>();
	private List<HiddenNode> hiddenNodes = new ArrayList<>();
	private List<BrainOutput> outputs = new ArrayList<>();

	public Brain(EvolvioColor evolvioColor, List<CreatureSensor> sensors, List<CreatureAction> actions) {
		this.evolvioColor = evolvioColor;

		for (CreatureSensor sensor : sensors) {
			this.inputs.add(new BrainInput(sensor));
		}

		for (CreatureAction action : actions) {
			this.outputs.add(new BrainOutput(action));
		}

		for (int i = 0; i < BRAIN_HIDDEN_NODES; i++) {
			HiddenNode hiddenNode = new HiddenNode();
			this.hiddenNodes.add(hiddenNode);

			for (BrainInput input : inputs) {
				double weight = Math.random() * 2 - 1;
				hiddenNode.addSender(input, weight);
			}

			for (BrainOutput output : outputs) {
				double weight = Math.random() * 2 - 1;
				hiddenNode.addReceiver(output, weight);
			}
		}
	}
	
	public void iterate(double timeStep) {
		for (BrainOutput output : outputs) {
			output.iterate(timeStep);
		}
	}

	public Brain evolve(List<Creature> parents) {
		// TODO Real implementation
		return null;
	}

	public void draw(float scaleUp, int mX, int mY) {
<<<<<<< HEAD
		final float neuronSize = 0.42f;
		this.evolvioColor.stroke(evolvioColor.color(0, 0, 1));
		this.evolvioColor.strokeWeight(2);
		this.evolvioColor.fill(0, 0, 0.35f);
		this.evolvioColor.rect(2 * NEURON_OFFSET_X - 10, -10, Configuration.BRAIN_WIDTH * (neuronSize * 2 + NEURON_SPACING) * scaleUp - NEURON_OFFSET_X / 2 + 40, 1000);
		
		this.evolvioColor.ellipseMode(EvolvioColor.RADIUS);
		this.evolvioColor.strokeWeight(2);
		this.evolvioColor.textSize(0.4f * scaleUp);
=======
		final float neuronSize = 0.4f;
		this.evolvioColor.noStroke();
		this.evolvioColor.fill(0, 0, 0.4f);
		this.evolvioColor.rect((-3.2f - neuronSize) * scaleUp, -neuronSize * scaleUp + 7.5f, //Bruteforced 7.5
				(3.8f + Configuration.BRAIN_WIDTH + neuronSize * 2) * scaleUp,
				(brainSize() + neuronSize * 2) * scaleUp);

		this.evolvioColor.ellipseMode(EvolvioColor.RADIUS);
		this.evolvioColor.strokeWeight(2);
		this.evolvioColor.textSize(0.25f * scaleUp);
>>>>>>> 6b0f8b4710f08505a438796e093befcf8b971e94
		this.evolvioColor.fill(0, 0, 1);
		
		int xIndex = 0;
		int yIndex = 0;
		for (BrainInput input : inputs) {
<<<<<<< HEAD
			if (input != null) {
				this.evolvioColor.textAlign(EvolvioColor.RIGHT);
				this.evolvioColor.fill(evolvioColor.color(0, 0, 0));
				this.evolvioColor.rect((-neuronSize) * scaleUp + NEURON_OFFSET_X - 68,
						(yIndex + (neuronSize * 0.45f)) * scaleUp + NEURON_OFFSET_Y - 20, 73, 25);
				
				this.evolvioColor.fill(evolvioColor.color(0, 0, 1));
				this.evolvioColor.text(input.getLabel(), (-neuronSize) * scaleUp + NEURON_OFFSET_X,
						(yIndex + (neuronSize * 0.45f)) * scaleUp + NEURON_OFFSET_Y);
				
				this.evolvioColor.fill(neuronFillColor(input.getLastValue()));
				this.evolvioColor.ellipse(xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 15,
						yIndex * scaleUp + NEURON_OFFSET_Y, neuronSize * scaleUp, neuronSize * scaleUp);
				
				this.evolvioColor.fill(neuronTextColor(input.getLastValue()));
				this.evolvioColor.textAlign(EvolvioColor.CENTER);
				this.evolvioColor.text(EvolvioColor.nf((float) input.getLastValue(), 0, 1),
						xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 15,
						(yIndex + (neuronSize * 0.45f)) * scaleUp + NEURON_OFFSET_Y);
				
=======
			this.evolvioColor.textAlign(EvolvioColor.RIGHT);
			if (input != null) {
				this.evolvioColor.text(input.getLabel(),
						(-neuronSize - 0.1f) * scaleUp + NEURON_OFFSET_X,
						(yIndex + (neuronSize * 0.5f)) * scaleUp + NEURON_OFFSET_Y);
				this.evolvioColor.fill(neuronFillColor(input.getLastValue()));
				this.evolvioColor.ellipse(xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 15,
						yIndex * scaleUp + NEURON_OFFSET_Y, neuronSize * scaleUp, neuronSize * scaleUp);
				this.evolvioColor.fill(neuronTextColor(input.getLastValue()));
				this.evolvioColor.text(EvolvioColor.nf((float) input.getLastValue(), 0, 2),
						xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 25,
						(yIndex + (neuronSize * 0.5f)) * scaleUp + NEURON_OFFSET_Y);
>>>>>>> 6b0f8b4710f08505a438796e093befcf8b971e94
				yIndex++;
			}
			
		}
		xIndex = 1;
		yIndex = 0;
		for (HiddenNode hiddenNode : hiddenNodes) {
			this.evolvioColor.textAlign(EvolvioColor.CENTER);
			this.evolvioColor.fill(neuronFillColor(hiddenNode.getWeight()));
			this.evolvioColor.ellipse(xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 15,
					yIndex * scaleUp + NEURON_OFFSET_Y, neuronSize * scaleUp, neuronSize * scaleUp);
<<<<<<< HEAD
			
			this.evolvioColor.fill(neuronTextColor(hiddenNode.getWeight()));
			this.evolvioColor.text(EvolvioColor.nf((float) hiddenNode.getWeight(), 0, 1),
					xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 15,
					(yIndex + (neuronSize * 0.45f)) * scaleUp + NEURON_OFFSET_Y);
			
=======
			this.evolvioColor.fill(neuronTextColor(hiddenNode.getWeight()));
			this.evolvioColor.text(EvolvioColor.nf((float) hiddenNode.getWeight(), 0, 2),
					xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 15,
					(yIndex + (neuronSize * 0.5f)) * scaleUp + NEURON_OFFSET_Y);
>>>>>>> 6b0f8b4710f08505a438796e093befcf8b971e94
			yIndex++;
		}
		xIndex = 2;
		yIndex = 0;
		for (BrainOutput output : outputs) {
<<<<<<< HEAD
			if (output != null) {
				this.evolvioColor.textAlign(EvolvioColor.LEFT);
				this.evolvioColor.fill(evolvioColor.color(0, 0, 0));
				this.evolvioColor.rect((neuronSize * ((15 / Configuration.BRAIN_WIDTH) + Configuration.BRAIN_WIDTH)) * scaleUp - 15 + NEURON_OFFSET_X,
						(yIndex + (neuronSize * 0.45f)) * scaleUp + NEURON_OFFSET_Y - 20, 115, 25);
				this.evolvioColor.fill(evolvioColor.color(0, 0, 1));
				this.evolvioColor.text(output.getLabel(), (neuronSize * ((15 / Configuration.BRAIN_WIDTH) + Configuration.BRAIN_WIDTH)) * scaleUp - 10 + NEURON_OFFSET_X,
						(yIndex + (neuronSize * 0.45f)) * scaleUp + NEURON_OFFSET_Y);
				// Hard Coded 10, No idea if there is a formula, just looked nice //
				
				this.evolvioColor.fill(neuronFillColor(output.getWeight()));
				this.evolvioColor.ellipse(xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 15,
						yIndex * scaleUp + NEURON_OFFSET_Y, neuronSize * scaleUp, neuronSize * scaleUp);
				
				this.evolvioColor.textAlign(EvolvioColor.CENTER);
				this.evolvioColor.fill(neuronTextColor(output.getWeight()));
				this.evolvioColor.text(EvolvioColor.nf((float) output.getWeight(), 0, 1),
						xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 15,
						(yIndex + (neuronSize * 0.45f)) * scaleUp + NEURON_OFFSET_Y);
				
=======
			this.evolvioColor.textAlign(EvolvioColor.LEFT);
			if (output != null) {
				this.evolvioColor.text(output.getLabel(),
						(neuronSize + 2.6f + 0.1f) * scaleUp + NEURON_OFFSET_X, //I just bruteforced the 2.6.
						(yIndex + (neuronSize * 0.5f)) * scaleUp + NEURON_OFFSET_Y);
				this.evolvioColor.fill(neuronFillColor(output.getWeight()));
				this.evolvioColor.ellipse(xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 15,
						yIndex * scaleUp + NEURON_OFFSET_Y, neuronSize * scaleUp, neuronSize * scaleUp);
				this.evolvioColor.fill(neuronTextColor(output.getWeight()));
				this.evolvioColor.text(EvolvioColor.nf((float) output.getWeight(), 0, 2),
						xIndex * scaleUp * NEURON_SPACING + NEURON_OFFSET_X + 5,
						(yIndex + (neuronSize * 0.5f)) * scaleUp + NEURON_OFFSET_Y);
>>>>>>> 6b0f8b4710f08505a438796e093befcf8b971e94
				yIndex++;
			}
		}
		
		/* TODO Mouse over stuff
		if (mX >= 0 && mX < Configuration.BRAIN_WIDTH && mY >= 0 && mY < BRAIN_HEIGHT) {
			for (int y = 0; y < BRAIN_HEIGHT; y++) {
				if (mX >= 1 && mY < BRAIN_HEIGHT - 1) {
					drawAxon(mX - 1, y, mX, mY, scaleUp);
				}
				if (mX < Configuration.BRAIN_WIDTH - 1 && y < BRAIN_HEIGHT - 1) {
					drawAxon(mX, mY, mX + 1, y, scaleUp);
				}
			}
		}
		*/
	}

	private void drawAxon(int x1, int y1, int x2, int y2, float scaleUp) {
		/* TODO
		this.evolvioColor.stroke(neuronFillColor(axons[x1][y1][y2].getWeight() * neurons[x1][y1]));
		this.evolvioColor.line(x1 * scaleUp * NEURON_SPACING + NEURON_OFFSET_X, y1 * scaleUp + NEURON_OFFSET_Y,
				x2 * scaleUp * NEURON_SPACING + NEURON_OFFSET_X, y2 * scaleUp + NEURON_OFFSET_Y);
		*/
	}
	
	private int neuronFillColor(double d) {
		if (d >= 0) {
			return this.evolvioColor.color(0, 0, 1, (float) (d));
		} else {
			return this.evolvioColor.color(0, 0, 0, (float) (-d));
		}
	}

	private int neuronTextColor(double d) {
		if (d >= 0) {
			return this.evolvioColor.color(0, 0, 0);
		} else {
			return this.evolvioColor.color(0, 0, 1);
		}
	}
	
	private int brainSize() {
		return Math.max(Math.max(inputs.size(), hiddenNodes.size()), outputs.size());
	}
}