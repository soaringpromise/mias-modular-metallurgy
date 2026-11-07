package net.soaringpromise.mmm.registry;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import net.soaringpromise.mmm.config.MetallurgyConfig;

public final class ModConfigs {

    public static final MetallurgyConfig METALLURGY = ConfigApiJava.registerAndLoadConfig(MetallurgyConfig::new);

    private ModConfigs() {
    }

    public static void init() {
    }
}