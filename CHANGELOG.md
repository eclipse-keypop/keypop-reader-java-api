# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
:warning: Major version aligning the API with version `3.0` of the
[CNA Terminal Reader API specification](https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/).
This release is **not** backward compatible with `2.x`.
### Added
- `CardReaderProvider`: standardized discovery and access to the readers available in the execution environment,
  obtained via `ReaderApiFactory.getCardReaderProvider()`.
- `CardDetectionSettings`: builder carrying the configuration of a card detection cycle (detection mode, RF
  technologies, ECP frame), obtained via `ReaderApiFactory.createCardDetectionSettings()`.
- `CardReaderEventHandler`: SPI merging the reception of reader events and of observation errors.
- `IsoCardTransactionManager` and `MultichannelCardTransactionManager`: multi-channel transaction manager contracts.
- `CardSelectionManager.processMultichannelCardSelectionScenario(CardReader, ChannelSelectionPolicy)`.
- `CardSelectionManager.CardPresenceNotificationPolicy`, `CardSelectionManager.SelectionExecutionPolicy` and
  `CardSelectionManager.ChannelSelectionPolicy` enumerations.
- `CardSelectionResult.getCardType()` and `CardSelectionResult.getActiveSelectionIndexes()`.
- `CardSelector.filterByCardType(CardType)`.
- `SmartCard.isActive()` and `IsoSmartCard.isBasicChannel()`.
- `ObservableCardReader.endCardProcessing()`.
- `CardReaderEvent.Type.READER_UNREGISTERED`.
### Changed
- `ObservableCardReader.startCardDetection(DetectionMode)` -> `startCardDetection(CardDetectionSettings,
  CardReaderEventHandler)`: the detection settings and the event handler are now provided at detection startup.
- `CardSelectionManager.processCardSelectionScenario(CardReader)` -> `processCardSelectionScenario(CardReader,
  SelectionExecutionPolicy)`.
- `CardSelectionManager.scheduleCardSelectionScenario(ObservableCardReader, NotificationMode)` ->
  `scheduleCardSelectionScenario(ObservableCardReader, CardPresenceNotificationPolicy, SelectionExecutionPolicy)`.
- `CardTransactionManager` is no longer generic and `T processCommands(ChannelControl)` becomes
  `void processCommands()`.
- `IsoCardSelector` now extends `CardSelector<IsoCardSelector>` directly and declares the ISO 7816-4 filters as well
  as the `FileOccurrence` and `FileControlInformation` enumerations.
- New dependency on the [Keypop Definitions API](https://github.com/eclipse-keypop/keypop-definitions-jvm-api)
  providing the `CardType` and `RfTechnology` enumerations.
### Removed
- `ConfigurableCardReader` and `ReaderProtocolNotSupportedException`: protocol filtering is replaced by
  `CardSelector.filterByCardType(CardType)` and `CardDetectionSettings.setRfTechnologies(Set)`.
- `ChannelControl`: replaced by `MultichannelCardTransactionManager.closeChannel()` and
  `processCommandsAndCloseChannel()`.
- `CommonIsoCardSelector`: merged into `IsoCardSelector`.
- `org.eclipse.keypop.reader.selection.InvalidCardResponseException`: duplicate of
  `org.eclipse.keypop.reader.InvalidCardResponseException`.
- `CardReaderObserverSpi` and `CardReaderObservationExceptionHandlerSpi`: merged into `CardReaderEventHandler`.
- `CardSelectionManager.setMultipleSelectionMode()`: replaced by `SelectionExecutionPolicy`.
- `CardSelectionManager.prepareReleaseChannel()`: replaced by `ChannelSelectionPolicy` and the multi-channel
  transaction managers.
- `ObservableCardReader.addObserver(...)`, `removeObserver(...)`, `clearObservers()`, `countObservers()` and
  `setReaderObservationExceptionHandler(...)`: a single `CardReaderEventHandler` is now registered at detection
  startup.
- `ObservableCardReader.finalizeCardProcessing()`: replaced by `endCardProcessing()`.
- `ObservableCardReader.DetectionMode`: moved to `CardDetectionSettings.DetectionMode`, the `SINGLESHOT` value being
  renamed `SINGLE_SHOT`.
- `ObservableCardReader.NotificationMode`: replaced by `CardSelectionManager.CardPresenceNotificationPolicy`.
- `CardReaderEvent.Type.UNAVAILABLE`: renamed `READER_UNREGISTERED`.
- `CardSelector.filterByCardProtocol(String)`: replaced by `filterByCardType(CardType)`.

## [2.1.0] - 2025-11-21
### Added
- Added `CardTransactionManager`: New interface providing common operations for all card transactions.
- Added `ChannelControl` enumeration: Defines the post-execution behavior of the physical channel.
- Added `InvalidCardResponseException`: Thrown when a card returns an invalid response during command processing.
### Fixed
- Fixed JUnit configuration.
### Changed
- Migrated the CI pipeline from Jenkins to GitHub Actions.

## [2.0.1] - 2024-04-12
### Changed
- Java source and target levels `1.6` -> `1.8`
### Upgraded
- Gradle `6.8.3` -> `7.6.4`

## [2.0.0] - 2023-11-27
:warning: The project has been migrated from the [Calypsonet Terminal Reader API](https://github.com/calypsonet/calypsonet-terminal-reader-java-api)
GitHub repository.
### Added
- `ReaderApiFactory` centralizes the methods used to create instances of the various interfaces of the API.
- `BasicCardSelector` can be used to create generic card selection filters based on card communication 
  protocol or power-on data.
- `IsoCardSelector` lets you create ISO card selection filters based on card communication protocol and 
  power-on data, as well as AIDs, and define selection strategies (e.g. first occurrence, FCI reading, etc.).
- `IsoSmartCard` extends the `SmartCard` interface and provides access to data from the **Select Application** ISO 
  command response.
### Changed
- The project license is now "MIT License" (previously "Eclipse Public License 2.0").
- CI: The Gradle plugin `org.eclipse.keyple:keyple-gradle:0.2.+` has been replaced
  by `org.eclipse.keypop:keypop-gradle:0.1.+`.
- Renamed:
  - Artifact `org.calypsonet.terminal:calypsonet-terminal-reader-java-api` -> `org.eclipse.keypop:keypop-reader-java-api`
  - Package `org.calypsonet.terminal.reader` -> `org.eclipse.keypop.reader`
  - Interface `CardSelection` -> `CardSelectionExtension`
- Moved:
  - Method `SmartCard.getSelectApplicationResponse()` ->  `IsoSmartCard.getSelectApplicationResponse()`
- Method signature refactored:
  - `CardSelectionManager.prepareSelection(CardSelection cardSelection)` -> `CardSelectionManager.prepareSelection(CardSelector<?> cardSelector, CardSelectionExtension cardSelectionExtension)`
  - `CardSelectionManager.scheduleCardSelectionScenario(ObservableCardReader observableCardReader, DetectionMode 
     detectionMode, NotificationMode notificationMode)` 
     -> `CardSelectionManager.scheduleCardSelectionScenario(ObservableCardReader observableCardReader, NotificationMode 
     notificationMode)`

## [1.3.0] - 2023-05-22
### Added
- Introduced a new capability to export a locally processed card selection scenario to be imported and analyzed remotely
  by another card selection manager.
  For this purpose, the following two methods have been added to the `CardSelectionManager` interface:
  - `exportProcessedCardSelectionScenario`
  - `importProcessedCardSelectionScenario`

## [1.2.0] - 2023-01-10
### Added
- `ConfigurableCardReader.getCurrentProtocol` method to retrieve the physical protocol name currently used by the reader.
### Changed
- UML diagrams moved to a dedicated repository (see `README.md` file).

## [1.1.0] - 2022-10-26
### Added
- The possibility to import/export a card selection scenario (issue [#9]) via the new methods
  `exportCardSelectionScenario` and `importCardSelectionScenario` of the `CardSelectionManager` API.
- `CHANGELOG.md` file (issue [#7]).
- CI: Forbid the publication of a version already released (issue [#5]).

## [1.0.0] - 2021-10-06
This is the initial release.

[unreleased]: https://github.com/eclipse-keypop/keypop-reader-java-api/compare/2.1.0...HEAD
[2.1.0]: https://github.com/eclipse-keypop/keypop-reader-java-api/compare/2.0.1...2.1.0
[2.0.1]: https://github.com/eclipse-keypop/keypop-reader-java-api/compare/2.0.0...2.0.1
[2.0.0]: https://github.com/eclipse-keypop/keypop-reader-java-api/releases/tag/2.0.0
[1.3.0]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/compare/1.2.0...1.3.0
[1.2.0]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/compare/1.1.0...1.2.0
[1.1.0]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/compare/1.0.0...1.1.0
[1.0.0]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/releases/tag/1.0.0

[#9]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/issues/9
[#7]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/issues/7
[#5]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/issues/5