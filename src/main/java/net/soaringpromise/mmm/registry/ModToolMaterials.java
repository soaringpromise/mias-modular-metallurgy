package net.soaringpromise.mmm.registry;

import net.minecraft.world.item.ToolMaterial;

public final class ModToolMaterials {
    public static final ToolMaterial SILVER = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_SILVER_TOOL,
            160, 10f, 1f, 25, ModTags.Items.SILVER_REPAIRABLES);

    public static final ToolMaterial STEEL = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
            1200, 8f, 3f, 13, ModTags.Items.STEEL_REPAIRABLES);

    public static final ToolMaterial LEAD = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_LEAD_TOOL,
            81, 11f, 4f, 10, ModTags.Items.LEAD_REPAIRABLES);

    private ModToolMaterials() {}
}