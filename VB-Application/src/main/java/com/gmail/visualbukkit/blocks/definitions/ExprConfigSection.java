package com.gmail.visualbukkit.blocks.definitions;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;

public class ExprConfigSection extends Expression {

    public ExprConfigSection() {
        super("expr-config-section", "Config Section", "Config", "A section of a config");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.of("org.bukkit.configuration.ConfigurationSection");
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter("Config", ClassInfo.of("org.bukkit.configuration.ConfigurationSection")), new ExpressionParameter("Section", ClassInfo.STRING)) {
            @Override
            public String toJava() {
                return arg(0) + ".getConfigurationSection(" + arg(1) + ")";
            }
        };
    }
}
