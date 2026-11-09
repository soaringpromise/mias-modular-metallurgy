# Mia's Modular Metallurgy (MMM)

![Minecraft 26.1.2](https://img.shields.io/badge/Minecraft-26.1.2-56A13D?style=flat-square)
![Fabric](https://img.shields.io/badge/Loader-Fabric-DBD0B4?style=flat-square)
![Build](https://img.shields.io/github/actions/workflow/status/soaringpromise/mias-modular-metallurgy/build.yml?branch=mc%2F26.1.2&style=flat-square&label=Build)
![MIT](https://img.shields.io/badge/License-MIT-blue?style=flat-square)
![Modrinth Downloads](https://img.shields.io/modrinth/dt/modular-metallurgy?style=flat-square&logo=modrinth&label=Downloads)
![Modrinth Version](https://img.shields.io/modrinth/v/modular-metallurgy?style=flat-square&logo=modrinth&label=Version)

**MMM** is a Vanilla+ Fabric mod that expands Minecraft's metals, tools, armor, and crafting, giving different materials their own strengths, weaknesses, and uses without replacing vanilla progression.

> **A note about textures:** MMM's textures come from **[The Silver Age](https://modrinth.com/mod/the-silver-age)**, **[The Lead Age](https://modrinth.com/mod/the-lead-age)**, and **[Alloyed (formerly Create: Alloyed)](https://modrinth.com/mod/create-alloyed)**. The artwork belongs to its respective creators and is reused under the projects' published licenses. **Please go check out these lovely mods and support their creators!** MMM is an independent project and is not affiliated with or endorsed by them. See [Third-Party Notices](THIRD_PARTY_NOTICES.md) for artwork credits and license information.

## Features

<details>
<summary>New Metals & Equipment</summary>

- **Silver:** Mine Silver Ore, craft tools and armor, and deal **2× damage to undead** with Silver weapons and tools. Silver Arrows travel faster and are especially effective against undead.
- **Steel:** Combine **1 Raw Iron + 2 Coal or Charcoal + 1 Calcite** into a Steel Blend, then refine it in a Blast Furnace. Craft sturdy equipment, Steel Shears, and a Steel Fishing Rod.
- **Lead:** Mine Lead Ore and craft heavy-hitting but relatively fragile tools, weapons, and armor.
- All three materials have nuggets, ingots, storage blocks, and equipment for players, horses, and nautiluses.
- Silver and Lead Ingots can also be used as **armor trim materials**.

</details>

<details>
<summary>Armor Set Bonuses & Drawbacks</summary>

Wear a complete matching armor set to activate its effects. Both advantages and disadvantages are disabled together when a set is switched off in the config.

| Armor     | Advantages                                                      | Drawbacks                                 |
|-----------|-----------------------------------------------------------------|-------------------------------------------|
| Leather   | +12% jump strength; −25% fall damage                            | Low vanilla protection                    |
| Gold      | +20% attack speed                                               | Low vanilla durability                    |
| Copper    | +12% movement speed; +20% mining speed                          | 4× lightning damage; +25% knockback taken |
| Chainmail | −15% melee damage taken                                         | +10% projectile damage taken              |
| Lead      | Innate Blast Protection II; +30% explosion knockback resistance | −4 maximum health                         |
| Iron      | +20% knockback resistance                                       | None                                      |
| Silver    | −25% damage taken from undead                                   | Low protection and durability             |
| Steel     | +4 maximum health                                               | −10% movement speed; −6% jump strength    |
| Diamond   | Innate Projectile Protection II                                 | +15% explosion damage taken               |
| Netherite | Innate Fire Protection II; −30% burning duration                | +20% gravity                              |

Armor tooltips describe each enabled set's effects.

</details>

<details>
<summary>Metallurgy & Crafting Improvements</summary>

- **Equipment recycling:** Smelt or blast eligible metal tools and armor into **one ingot** of their material instead of a nugget. Item tags allow other mods and datapacks to opt in.
- **Renewable Calcite:** Craft 2 Calcite from 2 Pointed Dripstone and 2 Bone Meal in a diagonal 2×2 pattern.
- **Expanded storage:** Convert ingots and nuggets, and craft raw Silver and Lead storage blocks.

</details>

## Requirements

- **Minecraft Java Edition 26.1.2** and **Fabric Loader**
- **Fabric API** and **fzzy_config**
- **Mod Menu** (optional, for in-game configuration)

MMM is required on both the client and server for multiplayer. The three credited texture-source mods are **not required dependencies**.

## Configuration

Each armor set's effects can be enabled or disabled independently through **fzzy_config**. Silver tools' bonus damage against undead also has its own toggle. Settings and descriptions are available in English and Spanish.

## Versions & Source

Each Minecraft version is maintained on its own Git branch, beginning with [`mc/26.1.2`](https://github.com/soaringpromise/mias-modular-metallurgy/tree/mc/26.1.2).

[Source Code](https://github.com/soaringpromise/mias-modular-metallurgy) · [Releases](https://github.com/soaringpromise/mias-modular-metallurgy/releases) · [Issues & Feedback](https://github.com/soaringpromise/mias-modular-metallurgy/issues)

## License & Artwork Credits

MMM's original code is licensed under the [MIT License](LICENSE). Textures used by MMM are credited to **The Silver Age**, **The Lead Age**, and **Alloyed**; their original copyright and license terms continue to apply. Please read [Third-Party Notices](THIRD_PARTY_NOTICES.md) for source links, contributors, and license details.
