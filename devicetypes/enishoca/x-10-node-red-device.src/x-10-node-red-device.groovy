/**
 *  X-10 Node Red Bridge Device Handler
 *
 * 	Author: Enis Hoca
 *   - enishoca@outlook.com
 *
 *  Copyright 2018 Enis Hoca
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 */
 
metadata {
  definition(name: "X-10 Node Red Device", namespace: "enishoca", author: "Enis Hoca") {
    capability "Switch"
    capability "Actuator"
  }
  simulator {
  }
  tiles {

    standardTile("switch", "device.switch", width: 1, height: 1, canChangeIcon: true) {
      state "on",
        label: '${name}',
        action: "switch.off",
        icon: "st.switches.switch.on",
        backgroundColor: "#79b821"
      state "off",
        label: '${name}',
        action: "switch.on",
        icon: "st.switches.switch.off",
        backgroundColor: "#ffffff"
    }

    main "switch"
    details(["switch"])
  }
}

// parse events into attributes
def parse(String description) {}

def on() {
  log.debug "Executing 'on'"
  sendEvent(name : "switch", value : "on");
}

def off() {
  log.debug "Executing 'off'"
  sendEvent(name : "switch", value : "off");
}

