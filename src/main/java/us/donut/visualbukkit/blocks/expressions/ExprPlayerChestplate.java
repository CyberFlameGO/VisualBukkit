package us.donut.visualbukkit.blocks.expressions;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import us.donut.visualbukkit.blocks.ExpressionBlock;
import us.donut.visualbukkit.blocks.ModificationType;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.annotations.Modifier;
import us.donut.visualbukkit.blocks.syntax.Syntax;

@Description({"The item stack in the chestplate slot of a player", "Returns: item stack"})
@Modifier(ModificationType.SET)
public class ExprPlayerChestplate extends ExpressionBlock<ItemStack> {

    @Override
    protected Syntax init() {
        return new Syntax("chestplate of", Player.class);
    }

    @Override
    public String toJava() {
        return arg(0) + ".getInventory().getChestplate()";
    }

    @Override
    public String modify(ModificationType modificationType, String delta) {
        return modificationType == ModificationType.SET ? arg(0) + ".getInventory().setChestplate(" + delta + ");" : null;
    }
}
