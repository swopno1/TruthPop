package com.example.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.model.Language
import com.vivescriptsolutions.truthpop.BuildConfig

@Composable
fun AboutDialog(
    language: Language,
    onDismiss: () -> Unit
) {
    val isBn = language == Language.BANGLA
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = if (isBn) "সম্পর্কে" else "About",
                tint = MaterialTheme.colorScheme.primary
            )
        },
        title = {
            Text(
                text = "TruthPop – Truth or Dare",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = if (isBn) "সংস্করণ ${BuildConfig.VERSION_NAME}" else "Version ${BuildConfig.VERSION_NAME}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (isBn) "প্রস্তুতকারক: ViveScript Solutions LLC" else "Developed by ViveScript Solutions LLC",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Website: https://www.vivescriptsolutions.com/",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "© 2026 ViveScript Solutions LLC.",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (isBn)
                        "সোর্স কোড MIT লাইসেন্সের অধীনে উন্মুক্ত। অ্যাপের নাম, লোগো, আইকন, স্ক্রিনশট, ট্রেডমার্ক ও ব্র্যান্ডিং ViveScript Solutions LLC-এর সম্পত্তি — MIT লাইসেন্সের অন্তর্ভুক্ত নয়।"
                    else
                        "The source code is licensed under the MIT License. The app name, logo, icons, screenshots, trademarks, and associated branding are proprietary property of ViveScript Solutions LLC and are not licensed under the MIT License.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = if (isBn) "গোপনীয়তা ও নিরাপত্তা" else "Privacy & Safety",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (isBn)
                        "• ১০০% অফলাইন গেমপ্লে — সব প্রম্পট অ্যাপের ভেতরেই আছে।\n• আমাদের পক্ষ থেকে কোনো অ্যাকাউন্ট বা ব্যক্তিগত তথ্য সংগ্রহ নেই; বিজ্ঞাপনের জন্য Google AdMob ডিভাইস শনাক্তকারী ব্যবহার করতে পারে।\n• চাপমুক্ত খেলা: প্রতিটি ডেয়ার ঐচ্ছিক, ইচ্ছেমতো স্কিপ করা যায়।\n• দুই ভাষা: ইংরেজি বা বাংলায় সাথে সাথে খেলো।"
                    else
                        "• 100% offline gameplay — prompts are built directly into the app.\n• No accounts or personal data collected by us; Google AdMob may use device identifiers for ads.\n• Pressure-free: every dare is optional and players can skip freely.\n• Dual language: Play instantly in English or Bangla.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                modifier = Modifier.testTag("about_dialog_close_button")
            ) {
                Text(if (isBn) "ঠিক আছে!" else "Got it!")
            }
        }
    )
}
