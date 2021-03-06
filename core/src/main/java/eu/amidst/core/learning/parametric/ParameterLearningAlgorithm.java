package eu.amidst.core.learning.parametric;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.  See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under the License.
 *
 */

import eu.amidst.core.datastream.DataInstance;
import eu.amidst.core.datastream.DataOnMemory;
import eu.amidst.core.datastream.DataStream;
import eu.amidst.core.models.BayesianNetwork;
import eu.amidst.core.models.DAG;

/**
 * This interface defines the Algorithm for learning the {@link eu.amidst.core.models.BayesianNetwork} parameters.
 *
 * <p> For an example of use follow this link </p>
 * <p> <a href="http://amidst.github.io/toolbox/CodeExamples.html#learningexample"> http://amidst.github.io/toolbox/CodeExamples.html#learningexample </a>  </p>
 */
public interface ParameterLearningAlgorithm {

    /**
     * Initializes the parameter learning process.
     */
    void initLearning();

    /**
     * Updates the model using a given {@link DataOnMemory} object.
     * @param batch a {@link DataOnMemory} object.
     * @return a double value.
     */
    double updateModel(DataOnMemory<DataInstance> batch);

    /**
     * Sets the {@link DataStream} to be used by this ParameterLearningAlgorithm.
     * @param data a {@link DataStream} object.
     */
    void setDataStream(DataStream<DataInstance> data);

    /**
     * Returns the log marginal probability.
     * @returnthe log marginal probability.
     */
    double getLogMarginalProbability();

    /**
     * Runs the parameter learning process.
     */
    void runLearning();

    /**
     * Sets the {@link DAG} structure.
     * @param dag a directed acyclic graph {@link DAG}.
     */
    void setDAG(DAG dag);

    /**
     * Sets the seed using a single {@code int} seed.
     * @param seed the initial seed.
     */
    void setSeed(int seed);

    /**
     * Returns the learnt {@link BayesianNetwork} model.
     * @return the learnt {@link BayesianNetwork} model.
     */
    BayesianNetwork getLearntBayesianNetwork();

    /**
     * Sets the parallel processing mode.
     * @param parallelMode {@code true} if the learning is performed in parallel, {@code false} otherwise.
     */
    void setParallelMode(boolean parallelMode);

    /**
     * Sets the Output.
     * @param activateOutput {@code true} if the output is activated, {@code false} otherwise.
     */
    void setOutput(boolean activateOutput);
}
