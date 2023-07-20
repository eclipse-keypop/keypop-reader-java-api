/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.reader.selection;

/**
 * Common ISO filters used to restrict the selection process to certain ISO 7816-4 cards.
 *
 * <p>These filters are all optional but can also be combined.
 *
 * <p>If no filtering is specified, any card that responds when inserted in the reader will be
 * considered selected.
 *
 * <p>Conversely, if one or more filters have been defined, the card will not be selected if one of
 * them rejects the card.
 *
 * @param <T> The type of the lowest level child object.
 * @since 2.0.0
 */
public interface CommonIsoCardSelector<T extends CommonIsoCardSelector<T>> extends CardSelector<T> {

  /**
   * Selects a card application DF by its name.
   *
   * <p>The DF is selected only if its name starts with the provided AID, as defined by ISO7816-4
   * chapter 4.2.
   *
   * <p>The provided AID will be used as a parameter of the "Selection Application" ISO card
   * command.
   *
   * @param aid The AID as a byte array containing 5 to 16 bytes.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided array is null or out of range.
   * @since 2.0.0
   */
  T filterByDfName(byte[] aid);

  /**
   * Selects a card application DF by its name.
   *
   * <p>The DF is selected only if its name starts with the provided AID, as defined by ISO7816-4
   * chapter 4.2.
   *
   * <p>The provided AID will be used as a parameter of the "Selection Application" ISO card
   * command.
   *
   * @param aid The AID as a hexadecimal string of 5 to 16 bytes.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided string is null, invalid or out of range.
   * @since 2.0.0
   */
  T filterByDfName(String aid);

  /**
   * Sets the file occurrence mode (see ISO7816-4).
   *
   * <p>The default value is {@link FileOccurrence#FIRST}.
   *
   * @param fileOccurrence The {@link FileOccurrence}.
   * @return The current instance.
   * @throws IllegalArgumentException If fileOccurrence is null.
   * @since 2.0.0
   */
  T setFileOccurrence(FileOccurrence fileOccurrence);

  /**
   * Sets the file control mode (see ISO7816-4).
   *
   * <p>The default value is {@link FileControlInformation#FCI}.
   *
   * @param fileControlInformation The {@link FileControlInformation}.
   * @return The current instance.
   * @throws IllegalArgumentException If fileControlInformation is null.
   * @since 2.0.0
   */
  T setFileControlInformation(FileControlInformation fileControlInformation);

  /**
   * Navigation options through the different applications contained in the card according to the
   * ISO7816-4 standard.
   *
   * @since 2.0.0
   */
  enum FileOccurrence {
    /**
     * First occurrence.
     *
     * @since 2.0.0
     */
    FIRST,
    /**
     * Last occurrence.
     *
     * @since 2.0.0
     */
    LAST,
    /**
     * Next occurrence.
     *
     * @since 2.0.0
     */
    NEXT,
    /**
     * Previous occurrence.
     *
     * @since 2.0.0
     */
    PREVIOUS
  }

  /**
   * Types of templates available in return for the Select Application command, according to the
   * ISO7816-4 standard.
   *
   * @since 2.0.0
   */
  enum FileControlInformation {
    /**
     * File control information.
     *
     * @since 2.0.0
     */
    FCI,
    /**
     * File control parameters.
     *
     * @since 2.0.0
     */
    FCP,
    /**
     * File management data.
     *
     * @since 2.0.0
     */
    FMD,
    /**
     * No response expected.
     *
     * @since 2.0.0
     */
    NO_RESPONSE
  }
}
