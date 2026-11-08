
package net.soaringpromise.mmm.registry;

import net.minecraft.world.item.ToolMaterial;

public final class ModToolMaterials {
    public static final ToolMaterial SILVER = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_SILVER_TOOL,
            96, 11f, 0.5f, 24,
            ModTags.Items.SILVER_REPAIRABLES
    );

    public static final ToolMaterial STEEL = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
            1080, 7.5f, 2.5f, 13,
            ModTags.Items.STEEL_REPAIRABLES
    );

    public static final ToolMaterial LEAD = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_LEAD_TOOL,
            80, 3.5f, 3.5f, 8,
            ModTags.Items.LEAD_REPAIRABLES
    );

    private ModToolMaterials() {}
}