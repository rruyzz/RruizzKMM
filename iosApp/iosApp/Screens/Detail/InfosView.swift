import SwiftUI

struct InfosView: View {
    var year: String
    var minutes: String
    
    var body: some View {
        HStack {
            Spacer()
            Text(year)
            Rectangle()
                .frame(width: 1, height: .infinity)
                    .foregroundColor(.gray)
            Text(minutes)
            Spacer()

        }
    }
}

#Preview {
    InfosView(year: "2020", minutes:"156 minutes")
}
