/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 ************************************************************************************** */
package org.eclipse.keypop.reader.spi;

import org.eclipse.keypop.reader.CardReaderEvent;
import org.eclipse.keypop.reader.ObservableCardReader;

/**
 * Reader observer to implement in order to receive {@link CardReaderEvent} from a {@link
 * ObservableCardReader}.
 *
 * @since 1.0.0
 */
public interface CardReaderObserverSpi {

  /**
   * Called when a reader event occurs.
   *
   * <p>The event notification should be done <b>sequentially</b> and <b>synchronously</b> but this
   * may depend on the implementation used.
   *
   * @param readerEvent The not null {@link CardReaderEvent} containing the event data.
   * @since 1.0.0
   */
  void onReaderEvent(CardReaderEvent readerEvent);
}
