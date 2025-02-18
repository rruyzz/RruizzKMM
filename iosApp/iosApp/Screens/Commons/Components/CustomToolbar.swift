import SwiftUI

struct CustomToolbar: View {
    let title: String
    var backAction: () -> Void
    var saveAction: () -> Void
    @State var isSaved: Bool
    
    var body: some View {
        HStack {
            Button(action: backAction) {
                Image(systemName: "chevron.left")
                    .font(.title2)
                    .foregroundColor(.white)
            }
            Spacer()
            Text(title)
                .font(.headline)
                .foregroundColor(.primary)

            Spacer()
            Button(action: saveAction) {
                Image(systemName: "heart")
                    .font(.title2)
                    .foregroundColor(.white)
            }
        }
        .frame(maxWidth: .infinity)
        .padding(.horizontal)
    }
}
