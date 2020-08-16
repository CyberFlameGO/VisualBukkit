package us.donut.visualbukkit.blocks.statements;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import us.donut.visualbukkit.blocks.StatementBlock;
import us.donut.visualbukkit.blocks.StatementCategory;
import us.donut.visualbukkit.blocks.annotations.Category;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.syntax.Syntax;

@Description("Opens a book to a player")
@Category(StatementCategory.PLAYER)
public class StatOpenBook extends StatementBlock {

    @Override
    protected Syntax init() {
        return new Syntax("open", ItemStack.class, "to", Player.class);
    }

    @Override
    public String toJava() {
        return arg(1) + ".openBook(" + arg(0) + ");";
    }
}
