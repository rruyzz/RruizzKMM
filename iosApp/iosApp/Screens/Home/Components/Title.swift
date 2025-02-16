
import SwiftUI
import shared

struct Title: View {
    var title: String
    
    var body: some View {
        Text(title)
            .font(.system(size: 16, weight: .medium))
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(16)
    }
}

