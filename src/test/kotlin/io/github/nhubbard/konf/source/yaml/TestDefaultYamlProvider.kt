/*
 * Copyright (c) 2017-2024 Uchuhimo
 * Copyright (c) 2024-present Nicholas Hubbard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for specific language governing permissions and
 * limitations under the License.
 */

package io.github.nhubbard.konf.source.yaml

import io.github.nhubbard.konf.source.Source
import io.github.nhubbard.konf.source.helpers.DefaultLoadersConfig
import io.github.nhubbard.konf.source.helpers.toConfig
import io.github.nhubbard.konf.tempFileOf
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
class TestDefaultYamlProvider {
    private val provider = { Source.from }
    private val item = DefaultLoadersConfig.type

    @Test
    fun testGivenProvider_onProvideSourceFromYamlFile_itShouldProvideAsAutoDetectedFileFormat() {
        val subject = provider()
        val config = subject.file(tempFileOf(yamlContent, suffix = ".yaml")).toConfig()
        assertEquals("yaml", config[item])
    }
}