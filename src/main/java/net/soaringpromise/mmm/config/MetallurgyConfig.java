package net.soaringpromise.mmm.config;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.config.ConfigGroup;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;
import net.soaringpromise.mmm.Mmm;

public class MetallurgyConfig extends Config {
    public static MetallurgyConfig INSTANCE;

    public ConfigGroup setBonuses = new ConfigGroup("setBonuses");
    public ValidatedBoolean leatherSetBonus = new ValidatedBoolean(true);
    public ValidatedBoolean goldSetBonus = new ValidatedBoolean(true);
    public ValidatedBoolean copperSetBonus = new ValidatedBoolean(true);
    public ValidatedBoolean chainmailSetBonus = new ValidatedBoolean(true);
    public ValidatedBoolean leadSetBonus = new ValidatedBoolean(true);
    public ValidatedBoolean ironSetBonus = new ValidatedBoolean(true);
    public ValidatedBoolean silverSetBonus = new ValidatedBoolean(true);
    public ValidatedBoolean steelSetBonus = new ValidatedBoolean(true);
    public ValidatedBoolean diamondSetBonus = new ValidatedBoolean(true);
    @ConfigGroup.Pop
    public ValidatedBoolean netheriteSetBonus = new ValidatedBoolean(true);

    public static void register() {
        INSTANCE = ConfigApiJava.registerAndLoadConfig(MetallurgyConfig::new);
    }

    public MetallurgyConfig() {
        super(Mmm.id("config"));
    }
}