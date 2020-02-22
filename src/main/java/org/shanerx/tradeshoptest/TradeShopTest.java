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
import org.shanerx.tradeshoptest.enumys.Setting;
import org.shanerx.tradeshoptest.listeners.*;

public class TradeShopTest extends JavaPlugin {

	private Metrics metrics;

	@Override
	public void onEnable() {

		PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new HopperShopAccessListener(this), this);
        pm.registerEvents(new PlayerShopChangeListener(this), this);
        pm.registerEvents(new PlayerShopCloseListener(this), this);
        pm.registerEvents(new PlayerShopCreateListener(this), this);
        pm.registerEvents(new PlayerShopDestroyListener(this), this);
        pm.registerEvents(new PlayerShopInventoryOpenListener(this), this);
        pm.registerEvents(new PlayerShopOpenListener(this), this);
        pm.registerEvents(new PlayerTradeListener(this), this);
		pm.registerEvents(new SuccessfulTradeListener(this), this);

		if (Setting.ALLOW_METRICS.getBoolean()) {
			metrics = new Metrics(this);
			getLogger().info("Metrics successfully initialized!");

		} else {
			getLogger().warning("Metrics are disabled! Please consider enabling them to support the authors!");
		}

	}
}
