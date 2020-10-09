package com.tooploox.local

val valid =
    """
    [
      {
       "Song Clean": "Caught Up in You",
       "ARTIST CLEAN": ".38 Special",
       "Release Year": 1982,
       "COMBINED": "Caught Up in You by .38 Special",
       "First?": 1,
       "Year?": 1,
       "PlayCount": 82,
       "F*G": 82
      }
    ]
""".trimIndent()

val noTitle =
    """
    [
      {
       "ARTIST CLEAN": ".38 Special",
       "Release Year": 1982,
       "COMBINED": "Caught Up in You by .38 Special",
       "First?": 1,
       "Year?": 1,
       "PlayCount": 82,
       "F*G": 82
      }
    ]
""".trimIndent()

val noArtistName =
    """
    [
      {
       "Song Clean": "Caught Up in You",
       "Release Year": 1982,
       "COMBINED": "Caught Up in You by .38 Special",
       "First?": 1,
       "Year?": 1,
       "PlayCount": 82,
       "F*G": 82
      }
    ]
""".trimIndent()

val noReleaseYear =
    """
    [
      {
       "Song Clean": "Caught Up in You",
       "ARTIST CLEAN": ".38 Special",
       "COMBINED": "Caught Up in You by .38 Special",
       "First?": 1,
       "Year?": 1,
       "PlayCount": 82,
       "F*G": 82
      }
    ]
""".trimIndent()