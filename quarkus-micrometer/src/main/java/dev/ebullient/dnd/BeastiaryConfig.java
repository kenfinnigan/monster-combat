/*
 * Copyright © 2020 IBM Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package dev.ebullient.dnd;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.ebullient.dnd.beastiary.Beastiary;
import dev.ebullient.dnd.beastiary.compendium.CompendiumReader;

@ApplicationScoped
public class BeastiaryConfig {
    static final Logger logger = LoggerFactory.getLogger(BeastiaryConfig.class);

    final Beastiary beastiary;

    public BeastiaryConfig() {
        this.beastiary = new Beastiary();
        try {
            CompendiumReader.addToBeastiary(beastiary);
        } catch (IOException e) {
            logger.error("Exception occurred filling the beastiary", e);
        }

        logger.debug("Created Beastiary: {}", beastiary);
    }

    public Beastiary getBeastiary() {
        return this.beastiary;
    }
}
