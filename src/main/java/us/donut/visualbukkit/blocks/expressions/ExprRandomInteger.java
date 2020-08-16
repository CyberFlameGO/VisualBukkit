package us.donut.visualbukkit.blocks.expressions;

import us.donut.visualbukkit.blocks.ExpressionBlock;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.syntax.Syntax;

@Description({"Generates a random integer between two numbers (inclusive)", "Returns: number"})
public class ExprRandomInteger extends ExpressionBlock<Integer> {

    @Override
    protected Syntax init() {
        return new Syntax("random integer between", int.class, "and", int.class);
    }

    @Override
    public String toJava() {
        return "java.util.concurrent.ThreadLocalRandom.current().nextInt(" + arg(0) + "," + arg(1) + "+1)";
    }
}
