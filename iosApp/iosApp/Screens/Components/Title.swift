
import SwiftUI
import shared

struct Title: View {
    var title: String
    
    var body: some View {
        Text(title)
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}
