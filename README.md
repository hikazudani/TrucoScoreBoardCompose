# TrucoScoreBoardCompose

## Description

This application is an electronic scoreboard for Truco matches. The user interface was implemented using Jetpack Compose, migrating from the traditional XML and Layout Inflater approach to a modern, declarative UI architecture with State Hoisting and componentization.

## Functionality

**Score Tracking**: Displays points for Team A and Team B.

**Score Adjustment**: Includes buttons to add 1 point and 3 points. The "+3" button is automatically hidden during the "mão de 11" state.

**Reset**: Features a button to restart the match points.

**Game Rules**: Monitors the "mão de 11" state, identifies the winning team at 12 points, and prevents further point additions after the game is over.

## Technical Specifications

**Language**: Kotlin

**UI Toolkit**: Jetpack Compose.

**Minimum API Level**: 26 (Android 8/Oreo).

**Package**: `br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose`.
