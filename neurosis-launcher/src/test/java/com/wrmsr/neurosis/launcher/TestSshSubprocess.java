/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wrmsr.neurosis.launcher;

import com.leacox.process.FinalizedProcess;
import com.leacox.process.FinalizedProcessBuilder;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestSshSubprocess
{
    @Test
    public void testShit()
            throws Throwable
    {
        FinalizedProcessBuilder pb = new FinalizedProcessBuilder("ssh", "-i", "~/.ssh/yelp_id_rsa", "wtimoney@10.56.5.48", "ls", "-l");
        try (FinalizedProcess process = pb.start()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            int returnVal = process.waitFor(5000);
        }
    }
}
