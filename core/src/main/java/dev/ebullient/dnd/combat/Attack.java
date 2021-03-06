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
package dev.ebullient.dnd.combat;

import java.util.List;
import java.util.regex.Pattern;

import dev.ebullient.dnd.mechanics.Ability;

public interface Attack {
    public Pattern SAVE = Pattern.compile("([A-Z]+)\\(([-+0-9]+)\\)");

    public interface Damage {
        String getAmount();

        String getType();

        List<Ability> getDisadvantage();

        String getSavingThrow();

        int getDuration();
    }

    String getName();

    Damage getDamage();

    String getDescription();

    int getAttackModifier();

    String getSavingThrow();

    Damage getAdditionalEffect();
}
