/*
 *
 *                         Copyright (c) 2016-2019
 *                SparklingComet @ http://shanerx.org
 *               KillerOfPie @ http://killerofpie.github.io
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *                http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  NOTICE: All modifications made by others to the source code belong
 *  to the respective contributor. No contributor should be held liable for
 *  any damages of any kind, whether be material or moral, which were
 *  caused by their contribution(s) to the project. See the full License for more information.
 *
 */

package org.shanerx.tradeshoptest;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.shanerx.tradeshoptest.listeners.HopperShopAccessListener;
import org.shanerx.tradeshoptest.listeners.PlayerPreTradeListener;
import org.shanerx.tradeshoptest.listeners.PlayerPrepareTradeListener;
import org.shanerx.tradeshoptest.listeners.PlayerShopChangeListener;
import org.shanerx.tradeshoptest.listeners.PlayerShopCloseListener;
import org.shanerx.tradeshoptest.listeners.PlayerShopCreateListener;
import org.shanerx.tradeshoptest.listeners.PlayerShopDestroyListener;
import org.shanerx.tradeshoptest.listeners.PlayerShopInventoryOpenListener;
import org.shanerx.tradeshoptest.listeners.PlayerShopOpenListener;
import org.shanerx.tradeshoptest.listeners.PlayerSuccessfulTradeListener;
import org.shanerx.tradeshoptest.listeners.TradeShopReloadListener;

public class TradeShopTest extends JavaPlugin {

    private Metrics metrics;
    private final int bstatsID = 0000;

	@Override
	public void onEnable() {

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new HopperShopAccessListener(this), this);
        pm.registerEvents(new PlayerPrepareTradeListener(this), this);
        pm.registerEvents(new PlayerPreTradeListener(this), this);
        pm.registerEvents(new PlayerShopChangeListener(this), this);
        pm.registerEvents(new PlayerShopCloseListener(this), this);
        pm.registerEvents(new PlayerShopCreateListener(this), this);
        pm.registerEvents(new PlayerShopDestroyListener(this), this);
        pm.registerEvents(new PlayerShopInventoryOpenListener(this), this);
        pm.registerEvents(new PlayerShopOpenListener(this), this);
        pm.registerEvents(new PlayerSuccessfulTradeListener(this), this);
        pm.registerEvents(new TradeShopReloadListener(this), this);

		/* Disabled for Test plugin since we won't be making a bstats page for it
		if (Setting.ALLOW_METRICS.getBoolean()) {
			metrics = new Metrics(this, bstatsID);
			getLogger().info("Metrics successfully initialized!");

		} else {
			getLogger().warning("Metrics are disabled! Please consider enabling them to support the authors!");
		}
		 */

	}
}
