package jaccob.blastfurnace.states;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import jaccob.blastfurnace.BlastFurnaceCoal;
import jaccob.blastfurnace.Defs;
import jaccob.blastfurnace.ScriptData;
import jaccob.blastfurnace.base.Interaction;
import jaccob.blastfurnace.base.Statee;
import jaccob.blastfurnace.base.StateData;
import jaccob.blastfurnace.base.TileInteraction;

public class BankWalk extends Statee<ScriptData> {

	public BankWalk() {
		super();
	}

	@Override
	public Statee<ScriptData> update(ScriptData data) {
		Tile bankPos = BlastFurnaceCoal.BANK_AREA.getRandomTile();
		TileInteraction interaction = new TileInteraction(bankPos, data.ctx);
		interaction.execute();
		
		if (bankPos.distanceTo(data.ctx.players.local().tile()) > 5) {
			data.ctx.movement.step(bankPos);
			//hoverBankArea();
		}

		data.methods.waitTillReasonableStop(5, null);
		
		return null;
	}
}
