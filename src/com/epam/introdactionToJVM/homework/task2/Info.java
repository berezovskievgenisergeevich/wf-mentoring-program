package com.epam.introdactionToJVM.homework.task2;

/**
 * Take your pet or current project app for the next exercises with JVM settings via flags and console utilities.
 * <p>
 * 1. Heap should be divided to Old and Young generations of equal size, where areas of Young generation are in following ratio: 3-Eden, 1-S0, 1-S1
 * Solution:
 * -XX: NewRatio = 2
 * <p>
 * 2. Heap should be of 512MB and divided to Old and Young generations of equal size, where areas of Young generation are in following ratio: 2-Eden, 1-S0, 1-S1
 * Solution:
 * -XX: NewRatio = 2
 * -Xms512m -Xmx512m
 *
 * 3. Heap should be of 512MB with Old generation of 128MB and Young generation with areas in following ratio: 3-Eden, 1-S0, 1-S1
 * <p>
 * 4. Heap should be divided to Old generation of 128MB and Young generations with areas: Eden of 384MB, S0 of 128MB, S1 of 128MB
 * <p>
 * After JVM start make screenshots with jdk monitoring tools with JVM flags for each point. Use this link to find appropriate tool. Check yourself with JVisualVM.
 */
public class Info {

}
