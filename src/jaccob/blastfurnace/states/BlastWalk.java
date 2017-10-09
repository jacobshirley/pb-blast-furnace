package jaccob.blastfurnace.states;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import jaccob.blastfurnace.Defs;
import jaccob.blastfurnace.ScriptData;
import jaccob.blastfurnace.base.ObjectInteraction;
import jaccob.blastfurnace.base.RandomMouseInteraction;
import jaccob.blastfurnace.base.State;

public class BlastWalk extends State<ScriptData>{
	@Override
	public State<ScriptData> update(ScriptData data) {
		ClientContext ctx = data.ctx;
		
		Tile random = new Tile(1939 + (int)Math.round(Math.random() * 3), 4967);
		ctx.movement.step(random);
		
		new RandomMouseInteraction(ctx, Defs.BLAST_MOUSE_MOVE_AREA[0], Defs.BANK_MOUSE_MOVE_AREA[1]).prepare();
		
		data.methods.waitTillReasonableStop(3, new ObjectInteraction(data.getConveyer()));
		
		return null;
	}

}
