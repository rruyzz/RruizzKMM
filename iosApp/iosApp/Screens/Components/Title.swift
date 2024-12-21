
import SwiftUI
import shared

struct Title: View {
    var title: String
    
    var body: some View {
        HStack {
            Text(title)
                .font(.system(size: 16, weight: .medium))
            Spacer()
        }.border(Color.blue)
    }
}

