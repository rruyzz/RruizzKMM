
import SwiftUI
import shared

struct Title: View {
    var title: String
    
    var body: some View {
        HStack() {
            Spacer().frame(width: 20)
            Text(title)
                .font(.system(size: 16, weight: .medium))
        }
    }
}

